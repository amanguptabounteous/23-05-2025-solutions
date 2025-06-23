import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { selectCartItems, selectCartTotal } from '../../state/selectors/cart.selectors';
import { select, Store } from '@ngrx/store';
import { AppState } from '../../state/app.state';
import { Observable } from 'rxjs';
import { Product } from '../../models/product.model';
import { decreaseQuantity, increaseQuantity, removeFromCart } from '../../state/actions/cart.actions';
import { CartItem } from '../../state/reducers/cart.reducers';

@Component({
  selector: 'app-cart',
  imports: [CommonModule],
  templateUrl: './cart.html',
  styleUrl: './cart.scss'
})
export class Cart {
  store = inject(Store<AppState>);
  cartItems$ = this.store.pipe(select(selectCartItems));
  cartTotal$ = this.store.pipe(select(selectCartTotal));


  increase(productId: number) {
  this.store.dispatch(increaseQuantity({ productId }));
}

decrease(productId: number) {
  this.store.dispatch(decreaseQuantity({ productId }));
}

remove(productId: number) {
  this.store.dispatch(removeFromCart({ productId }));
}

}


