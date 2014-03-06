package org.multibit.exchange.presentation.model.marketdepth;

import com.yammer.dropwizard.testing.JsonHelpers;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.multibit.common.DateUtils;
import org.multibit.exchange.testing.ExchangeIdFaker;
import org.multibit.exchange.testing.TickerFaker;

import static org.fest.assertions.api.Assertions.assertThat;

public class MarketDepthPresentationModelTest {

  @Test
  public void testSerializeThenDeserialize() throws Exception {
    // Arrange
    String id = new ObjectId().toString();
    String exchangeId = ExchangeIdFaker.createValid().getCode();
    String tickerSymbol = TickerFaker.createValid().getSymbol();
    MarketDepthPresentationModel model = new MarketDepthPresentationModel(id, exchangeId, tickerSymbol);
    model.setUpdateTimestamp(DateUtils.nowUtc());

    BidDepthData bidDepthData = model.getBidDepthData();
    AskDepthData askDepthData = model.getAskDepthData();

    bidDepthData.increaseVolumeAtPrice("22", "8");
    bidDepthData.increaseVolumeAtPrice("12", "12.884");
    bidDepthData.increaseVolumeAtPrice("11", "20000");

    askDepthData.increaseVolumeAtPrice("22.50", "100");
    askDepthData.increaseVolumeAtPrice("25", "120");
    askDepthData.increaseVolumeAtPrice("26", "100");

    // Act
    String json = JsonHelpers.asJson(model);

    // Act
    MarketDepthPresentationModel deserialized = JsonHelpers.fromJson(json, MarketDepthPresentationModel.class);

    // Assert
    assertThat(deserialized).isEqualTo(model);
  }

}
