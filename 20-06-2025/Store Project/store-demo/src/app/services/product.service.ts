import { Injectable } from '@angular/core';
import { Product as ProductModel } from '../models/product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private products: ProductModel[] = [
    {
      id: 1, name: 'TV', description: 'A 42 inch TV', stock: 10, price: 45000, imageUrl: 'https://darlingretail.com/cdn/shop/files/8_6.png?v=1748407864'
    },
     { id: 2, name: 'Phone', description: 'Smartphone 5G', stock: 5, price: 65000, imageUrl: 'https://pngimg.com/uploads/iphone_13/iphone_13_PNG27.png' },
    { id: 3, name: 'Laptop', description: 'Gaming Laptop', stock: 0, price: 145000, imageUrl: 'https://dlcdnwebimgs.asus.com/files/media/5aa8cb62-57ee-482e-b5f4-6bdb6a5ba3a9/images/products/new/90NR0CC1-M013C0.png' },
    { id: 4, name: 'Headphones', description: 'Noise-cancelling headphones', price: 12500,stock: 15, imageUrl: 'https://media-ik.croma.com/prod/https://media.croma.com/image/upload/v1682596094/Croma%20Assets/Entertainment/Headphones%20and%20Earphones/Images/270321_0_afsc6p.png?tr=w-640' },
    { id: 5, name: 'Smartwatch', description: 'Fitness smartwatch', stock: 8, price: 5000,imageUrl: 'https://images.snapmint.com/product_assets/images/000/957/959/large/data?17149653330' }
  ];

  getProducts(): ProductModel[] {
    return this.products;
  }

  constructor() { }
}
