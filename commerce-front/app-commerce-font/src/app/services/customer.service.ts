import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpClient :HttpClient) {

  }
  public getCustomers():any {
    return this.httpClient.get("http://localhost:8080/CUSTOMER-SERVICE/customers");
  }
}
