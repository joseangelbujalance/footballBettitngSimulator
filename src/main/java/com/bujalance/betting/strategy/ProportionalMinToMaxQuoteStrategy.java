package com.bujalance.betting.strategy;

import com.bujalance.betting.model.BettingEvent;
import com.bujalance.betting.model.Odd;

/**
 * We bet on the minimum quote odd with a variable quantity.
 * The quantity to bet is given by the formula: {@code quantity = baseQuantity * maxQuote / minQuote}.
 * Thus, the bigger gap between odds, the bigger quantity is bet, reducing the loses.
 */
public class ProportionalMinToMaxQuoteStrategy extends AbstractStrategy {

	public ProportionalMinToMaxQuoteStrategy(final double pBaseQuantity) {
		super(pBaseQuantity);
	}

	@Override
	public Odd getChosenOdd(final BettingEvent pEvent) {
		return pEvent.getMinimumQuoteOdd();
	}

	@Override
	public double getQuantity(final BettingEvent pEvent) {
		return fBaseQuantity * pEvent.getMaximumQuoteOdd().getQuote() / pEvent.getMinimumQuoteOdd().getQuote();
	}
}
