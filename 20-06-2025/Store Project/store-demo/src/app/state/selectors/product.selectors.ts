import { createSelector } from "@ngrx/store";
import { AppState } from "../app.state";
import { ProductState } from "../reducers/product.reducers";

export const selectProductState = (state: AppState) => state.products;  

export const selectProducts = createSelector(
  selectProductState,
  (state: ProductState) => state.products
);