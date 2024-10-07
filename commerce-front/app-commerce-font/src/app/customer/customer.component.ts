import { Component } from '@angular/core';
import {CustomerService} from "../services/customer.service";
import {Customer} from "../modules/Customer.module";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrl: './customer.component.css'
})
export class CustomerComponent {
  customers!:Customer[];
  constructor(private customerService:CustomerService ) {
    customerService.getCustomers().subscribe((data: { _embedded: { customers: Customer[]; }; })=>this.customers=data._embedded.customers);
  }

  getOrders(id: number) {
    console.log("Customer ID: "+id);
  }
}
