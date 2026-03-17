class Solution {
    public int solution(int price) {
        if(price >= 100000 && 300000 > price) {
            return price * 95 / 100;
        } else if(price >= 300000 && 500000 > price) {
            return price * 90 / 100;
        } else if(500000 <= price) {
            return price * 80 / 100;
        }

        return price;
    }
}