package org.multibit.exchange.domain;

import com.google.common.base.Strings;
import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;


import static com.google.common.base.Preconditions.checkArgument;

/**
 * <p>Command to provide the following to the application:</p>
 * <ul>
 * <li>an event driven mechanism for creating a new security</li>
 * </ul>
 *
 * @since 0.0.1
 *         
 */
public class SecurityCreatedEvent {

  @TargetAggregateIdentifier
  private final String tickerSymbol;

  private final String tradeableItemSymbol;

  private final String currencySymbol;

  public SecurityCreatedEvent(String tickerSymbol, String tradeableItemSymbol, String currencySymbol) {

    checkArgument(!Strings.isNullOrEmpty(tickerSymbol), "tickerSymbol must not be null or empty: '%s'", tickerSymbol);
    checkArgument(!Strings.isNullOrEmpty(tradeableItemSymbol), "tradeableItemSymbol must not be null or empty: '%s'", tradeableItemSymbol);
    checkArgument(!Strings.isNullOrEmpty(currencySymbol), "currencySymbol must not be null or empty: '%s'", currencySymbol);

    this.tickerSymbol = tickerSymbol;
    this.tradeableItemSymbol = tradeableItemSymbol;
    this.currencySymbol = currencySymbol;
  }

  public String getTickerSymbol() {
    return tickerSymbol;
  }

  public String getTradeableItemSymbol() {
    return tradeableItemSymbol;
  }

  public String getCurrencySymbol() {
    return currencySymbol;
  }

  @Override
  public String toString() {
    return "SecurityCreatedEvent{" +
        "tickerSymbol='" + tickerSymbol + '\'' +
        ", tradeableItemSymbol='" + tradeableItemSymbol + '\'' +
        ", currencySymbol='" + currencySymbol + '\'' +
        '}';
  }
}
