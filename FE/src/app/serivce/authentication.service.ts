import { Injectable } from '@angular/core';
import {HttpClient, HttpClientModule, HttpResponse} from "@angular/common/http";
import {User} from "../model/user";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  baseApi: string = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public login(user: User): Observable<HttpResponse<any>>
  {
    return this.http.post<HttpResponse<any>>(`${this.baseApi}/login`, user, {observe: 'response'});
  }

  public addUserToLocalCache(user: User): void
  {
    localStorage.setItem("user", JSON.stringify(user));
    localStorage.setItem("username", JSON.stringify(user?.username));
    localStorage.setItem("id", JSON.stringify(user?.id));
    localStorage.setItem("role", JSON.stringify(user?.role));
  }

  public isUserLoggedIn(): boolean {
    let user = localStorage.getItem("user");
    if(user === null)
    {
      return false
    }
    return true
  }
}
