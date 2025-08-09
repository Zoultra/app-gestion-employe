import { ApplicationConfig, provideBrowserGlobalErrorListeners, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
import { jwtErrorInterceptor } from '../app/services/auth/jwt-error.interceptor';
import { routes } from './app.routes';
import {provideHttpClient  } from '@angular/common/http';

import { HTTP_INTERCEPTORS } from '@angular/common/http';

export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
      provideHttpClient(),
      { provide: HTTP_INTERCEPTORS, useClass: jwtErrorInterceptor, multi: true }
  ]
};

 