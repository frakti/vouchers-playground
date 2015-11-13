package shop;

import pl.rspective.voucherify.client.VoucherifyClient;
import pl.rspective.voucherify.client.VoucherifyUtils;
import pl.rspective.voucherify.client.callback.VoucherifyCallback;
import pl.rspective.voucherify.client.model.Voucher;
import retrofit.RetrofitError;

import java.math.BigDecimal;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    VoucherifyClient client = new VoucherifyClient.Builder()
            .setAppId("c70a6f00-cf91-4756-9df5-47628850002b")
            .setAppToken("3266b9f8-e246-4f79-bdf0-833929b1380c")
//            .setLogLevel(RestAdapter.LogLevel.FULL)
            .build();

    System.out.println("Talking with voucherify.io");

    final String TEST_CODE = "Testing7fjWdr";

    client.vouchers().async().fetchVoucher(TEST_CODE, new VoucherifyCallback<Voucher>() {

      @Override
      public void onSuccess(Voucher voucher) {
        BigDecimal originalPrice = BigDecimal.valueOf(8);
        BigDecimal newPrice = VoucherifyUtils.calculatePrice(originalPrice, voucher);
        BigDecimal discount = VoucherifyUtils.calculateDiscount(originalPrice, voucher);

        System.out.println("Original price: " + originalPrice.toString());
        System.out.println("Price after discount: " + newPrice.toString());
        System.out.println("Discount: " + discount.toString());
        System.out.println("Discount Type: " + voucher.getDiscountType());


        Voucher voucherAfterRedemption = client.vouchers().redeem(TEST_CODE, "static-main-java-by-frakti");


        int redeemedQuantity = voucherAfterRedemption.getRedemption().getRedeemedQuantity();
        System.out.println("Redeemed quantity: " + redeemedQuantity);
      }

      @Override
      public void onFailure(RetrofitError error) {
        System.out.println("An error occurred: " + error.toString());
      }
    });




    Thread.sleep(2000);
  }
}
