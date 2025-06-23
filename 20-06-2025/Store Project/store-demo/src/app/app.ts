import { Component, inject } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { ProductList } from './components/product-list/product-list';
import { Cart } from './components/cart/cart';
import { select, Store } from '@ngrx/store';
import { selectCartItemCount, selectCartItems } from './state/selectors/cart.selectors';
import { AppState } from './state/app.state';
import { map } from 'rxjs';
import { AsyncPipe, CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [CommonModule, RouterOutlet, RouterLink, AsyncPipe],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected title = 'store-demo';
  private store = inject(Store<AppState>);
  private router = inject(Router);

  cartCount$ = this.store.pipe(select(selectCartItemCount));

  navigateToCart() {
    this.router.navigate(['/cart']);
  }
}
