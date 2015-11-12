((document, $, Voucherify) => {
    'use strict';

    $(document).ready(() => {

        Voucherify.initialize(
          "011240bf-d5fc-4ef1-9e82-11eb68c43bf5",
          "9e2230c5-71fb-460a-91c6-fbee64707a20"
        );
        Voucherify.setIdentity("testvoucher-by-frakti");


        $("#validate").on('click', () => {
            let code = $('#code').val();

            Voucherify
                .validate(code)
                .done(voucher => {
                    if (!voucher.valid) {
                        alert('Coupon not valid');
                    } else {
                        let productPrice = $("#price").val();

                        $("#discountPrice").text(Voucherify.utils.calculatePrice(+productPrice, voucher));
                        $("#discountType").text(voucher.discount_type);
                        $("#discount").text(Voucherify.utils.calculateDiscount(+productPrice, voucher));
                    }
                })
                .fail(err => alert('An error occurred: ', err));
        });

    });
})(window.document, window.jQuery, window.Voucherify);