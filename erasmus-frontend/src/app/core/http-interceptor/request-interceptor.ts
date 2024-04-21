import {HttpInterceptorFn} from "@angular/common/http";

export const requestInterceptor: HttpInterceptorFn = (req, next) => {
  const modifiedReq = req.clone({
    url: getUrl(req.url)
  });

  return next(modifiedReq);
};

const getUrl = (url: string): string => {
  return 'http://localhost:8777/api/' + url;
};
