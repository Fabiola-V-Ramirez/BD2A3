import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Router } from '@angular/router';

import { AuthenticationService } from '../services/authentication.service';

@Injectable()
export class AuthenticationInterceptor implements HttpInterceptor {
  constructor(
    private authenticationService: AuthenticationService,
    private router: Router
  ) {}

  intercept(
    request: HttpRequest<unknown>,
    next: HttpHandler
  ): Observable<HttpEvent<unknown>> {
    const updatedRequest = request.clone({
      setHeaders: {
        Authorization: `Bearer ${this.authenticationService.bearerToken}`,
      },
    });
    return next.handle(updatedRequest).pipe(
      catchError((err) => {
        if (err.status === 403 || err.status === 401) {
          this.router.navigate(['/login']);
          return throwError(err);
        } else {
          return throwError(err);
        }
      })
    );
  }
}
