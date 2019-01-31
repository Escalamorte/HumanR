public class NetSal {
        private double minSal = 200;
        private double maxSal = 8000;
        double net;


        public double calcSal (double a) {
            if (a > 8000) {
                net = a - ((a - 8000) * 0.14) - ((a - 200) * 0.3) - 6 - (a * 0.5) ;
            } else {
                net = a * 0.14;
            }
            return net;
        }
}
