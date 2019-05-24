package klondike.models.builders;

import klondike.models.Stock;

public class EmptyStockBuilder {

	public Stock build() {
		Stock stock = new Stock();
		while (!stock.empty()) {
			stock.pop();
		}
		return stock;
	}
}
