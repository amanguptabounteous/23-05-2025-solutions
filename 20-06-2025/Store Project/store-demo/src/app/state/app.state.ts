import { ProductState } from "./reducers/product.reducers";
import { CartState } from "./reducers/cart.reducers";

export interface AppState {
  products: ProductState;
  cart: CartState;
}