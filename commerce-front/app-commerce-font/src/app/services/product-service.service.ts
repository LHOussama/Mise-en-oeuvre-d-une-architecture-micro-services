import { Injectable } from '@angular/core';
import {Product} from "../modules/Poduct.module";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {
  url: string = "http://localhost:8080/ENVONTORY-SERVICE/products";

  constructor(private httpClient: HttpClient) {
  }

  public getProducts():any {
    return this.httpClient.get<Product[]>(this.url);
  }

}
