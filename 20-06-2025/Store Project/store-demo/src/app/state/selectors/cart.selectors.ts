import { createSelector } from "@ngrx/store";
import { AppState } from "../app.state";
import { CartState, CartItem } from "../reducers/cart.reducers";

export const selectCartState = (state: AppState) => state.cart;

export const selectCartItems = createSelector(
  selectCartState,
  (state: CartState) => state.items
);

export const selectCartTotal = createSelector(
  selectCartItems,
  (items) => items.reduce((total, item) => total + (item.price * item.quantity), 0)
);

export const selectCartItemCount = createSelector(
  selectCartItems,
  (items: CartItem[]) => items.reduce((acc, item) => acc + item.quantity, 0)
);

