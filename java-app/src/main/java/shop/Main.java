package shop;

import pl.rspective.voucherify.client.VoucherifyClient;
import pl.rspective.voucherify.client.callback.VoucherifyCallback;
import pl.rspective.voucherify.client.model.Voucher;
import retrofit.RetrofitError;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class Main {
  public static void main(String[] args) {
    VoucherifyClient client = new VoucherifyClient.Builder()
            .setAppId("c70a6f00-cf91-4756-9df5-47628850002b")
            .setAppToken("3266b9f8-e246-4f79-bdf0-833929b1380c")
            .build();

    System.out.println("Talking with voucherify.io");


    try {
      Voucher voucher = client.vouchers().fetchVoucher("Testing7fjWdr");
      System.out.println("Sync result: " + voucher.getDiscount());

    } catch (RetrofitError e) {
      System.out.println("Error " + e.getBody().toString());
    }

    client.vouchers().async().fetchVoucher("Testing7fjWdr", new VoucherifyCallback<Voucher>() {
      @Override
      public void onSuccess(Voucher result) {
        System.out.println(result.toString());
      }

      @Override
      public void onFailure(RetrofitError error) {
        System.out.println("An error occurred: " + error.toString());
      }
    });

    client.vouchers()
            .rx()
            .fetchVoucher("VOUCHER_CODE")
            .subscribeOn(Schedulers.io())
            .subscribe(new Subscriber<Voucher>() {

              @Override
              public void onCompleted() {
                System.out.println("Rx completed");
              }

              @Override
              public void onError(Throwable e) {
                System.out.println("error e" + e.toString());
              }

              @Override
              public void onNext(Voucher voucher) {

                System.out.println("RX: " + voucher.getDiscount());
              }
            });
  }
}
