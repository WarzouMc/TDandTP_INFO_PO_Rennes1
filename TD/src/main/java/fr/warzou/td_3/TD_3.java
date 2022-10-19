package fr.warzou.td_3;

public class TD_3 {

    public static class Vote {
        private int republicain;
        private int democrate;
        private boolean votable = true;

        public Vote() {
            this.republicain = 0;
            this.democrate = 0;
        }

        public void finDuVote() {
            this.votable = false;
        }

        public void voterRepublicain() {
            vote(this.republicain);
        }

        public void voterDemocrate() {
            vote(this.democrate);
        }

        public int getTotalVote() {
            return this.democrate + this.republicain;
        }

        public int getVoteRepublicain() {
            return this.republicain;
        }

        public int getVoteDemocrate() {
            return this.democrate;
        }

        @Override
        public String toString() {
            return "Vote{" +
                    "winner=" + (democrateWinner() ? "democrate" : "republicain") +
                    ", pourcentage=(democrate=" + democratePercent() + ",republicain=" + (1 - democratePercent()) + ")" +
                    ", votable=" + votable +
                    '}';
        }

        private double democratePercent() {
            return (this.democrate + 0.0) / (this.democrate + this.republicain);
        }

        private boolean democrateWinner() {
            return democratePercent() >= 0.5;
        }

        private void vote(int vote) {
            if (!this.votable)
                return;
            vote++;
        }
    }

    public static class Intervalle {
        private int left;
        private int right;

        public Intervalle(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public boolean intersect(Intervalle intervalle) {
            return this.left <= intervalle.right || this.right >= intervalle.right;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getLeft() {
            return left;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public int getRight() {
            return right;
        }

        @Override
        public String toString() {
            return "[" + this.left + " ; " + this.right + "]";
        }
    }

}
