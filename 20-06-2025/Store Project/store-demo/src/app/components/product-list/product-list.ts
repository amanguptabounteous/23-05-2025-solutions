import { Component, inject } from '@angular/core';
import { AppState } from '../../state/app.state';
import { select, Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { Product } from '../../models/product.model';
import { CommonModule } from '@angular/common';
import { ProductService } from '../../services/product.service';
import { addToCart } from '../../state/actions/cart.actions';
import { selectProducts } from '../../state/selectors/product.selectors';

@Component({
  selector: 'app-product-list',
  imports: [CommonModule],
  templateUrl: './product-list.html',
  styleUrl: './product-list.scss'
})
export class ProductList {
  store = inject(Store<AppState>);
  productService = inject(ProductService);

  products$: Observable<Product[]> = this.store.pipe(select(selectProducts));

  constructor() {
    const products = this.productService.getProducts();
    this.store.dispatch({ type: '[Product] Load Products Success', products });
  }

  addToCart(product: Product) {
    this.store.dispatch(addToCart({ product }));
  }
}
