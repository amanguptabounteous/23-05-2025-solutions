import { createReducer, on } from "@ngrx/store";
import { loadProductsSuccess } from "../actions/product.actions";
import { Product } from "../../models/product.model";
import e from "express";
import { addToCart } from "../actions/cart.actions";

export interface ProductState {
  products: Product[];
}

export const initialState: ProductState = {
  products: []
}

export const productReducer = createReducer(
  initialState,
  on(loadProductsSuccess, (state, { products }) => ({
    ...state,
    products: [...products]
  })),
  on(addToCart, (state, { product }) => ({
    ...state,
    products: state.products.map(p => 
      p.id === product.id && p.stock > 0
      ? { ...p, stock: p.stock - 1 }
      : p
    )
  }))
);