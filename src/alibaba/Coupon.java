package alibaba;

import java.util.List;

/**
 * Created by zkf on 4/20/16.
 */
public class Coupon {
    final int threshold;

    public Coupon(int threshold) {
        this.threshold = threshold;
    }


    private static class Baoyou extends Coupon {

        public Baoyou(int threshold) {
            super(threshold);
        }
    }

    private static class Manjian extends Coupon {
        final int cut;

        private Manjian(int threshold, int cut) {
            super(threshold);
            this.cut = cut;
        }
    }

    public static Coupon chooseCoupon(List<Coupon> coupons, int oriAmount, int shipFee) {
        int maxCut = 0;
        Coupon coupon = null;
        for (Coupon c : coupons) {
            if (oriAmount < c.threshold) continue;

            int cut = (c instanceof Manjian) ? ((Manjian)c).cut : shipFee;
            if (cut > maxCut) {
                maxCut = cut;
                coupon = c;
            }
        }

        return coupon;
    }
}
