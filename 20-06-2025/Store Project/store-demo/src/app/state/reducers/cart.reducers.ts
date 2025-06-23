import { createReducer, on } from '@ngrx/store';
import { addToCart, increaseQuantity, decreaseQuantity, removeFromCart } from '../actions/cart.actions';
import { Product } from '../../models/product.model';

export interface CartItem {
  id: number;
  name: string;
  description: string;
  price: number; // Add this
  quantity: number;
}


export interface CartState {
  items: CartItem[];
}

export const initialState: CartState = {
  items: []
};

export const cartReducer = createReducer(
  initialState,
  on(addToCart, (state, { product }) => {
  const existingItem = state.items.find(item => item.id === product.id);

  if (existingItem) {
    return {
      ...state,
      items: state.items.map(item =>
        item.id === product.id ? { ...item, quantity: item.quantity + 1 } : item
      )
    };
  } else {
    return {
      ...state,
      items: [...state.items, { 
        id: product.id, 
        name: product.name, 
        description: product.description, 
        price: product.price, // Add price here
        quantity: 1 
      }]
    };
  }
}),
  on(increaseQuantity, (state, { productId }) => ({
    ...state,
    items: state.items.map(item =>
      item.id === productId ? { ...item, quantity: item.quantity + 1 } : item
    )
  })),
  on(decreaseQuantity, (state, { productId }) => ({
    ...state,
    items: state.items.map(item =>
      item.id === productId && item.quantity > 1 ? { ...item, quantity: item.quantity - 1 } : item
    )
  })),
  on(removeFromCart, (state, { productId }) => ({
    ...state,
    items: state.items.filter(item => item.id !== productId)
  }))
);
