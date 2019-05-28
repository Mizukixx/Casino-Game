public class Play {

    void casino(User u){
        System.out.println("-------------------");
        System.out.println("あなたの現在の所持金は"+ u.getMoney()+ "円です。");
        int betMoney;
        while (true) {
            System.out.print("いくらを賭けますか？▶︎");
            betMoney = new java.util.Scanner(System.in).nextInt();
            if (betMoney <= u.getMoney()) {
                break;
            } else {
                System.out.println("");
                System.out.println("[エラー]");
                System.out.println("所持金を超える額を賭けることはできません。");
                System.out.println("入力をやり直してください。");
                System.out.println("-------------------");
            }
        }
        System.out.println("");
        int nowMoney = u.getMoney() - betMoney;
        System.out.println("あなたは"+ betMoney+ "円を賭けました。(所持金："+ nowMoney +"円)");
        System.out.println("");
        String select[]= {"赤", "白"};
        System.out.println("赤と白、どちらに賭けますか？");
        int bet;
        while (true) {
            System.out.println("0: 赤（偶数）");
            System.out.println("1: 白（奇数）");
            System.out.print("賭ける方の番号を入力してください：");
            bet = new java.util.Scanner(System.in).nextInt();
            if (bet == 0 || bet ==1) {
                break;
            }
            else {
                System.out.println("");
                System.out.println("[エラー]");
                System.out.println("正しい番号を入力してください。");
                System.out.println("-------------------");
            }
        }
        int result = new java.util.Random().nextInt(100);
        System.out.println(u.getName() + "さんは、"+ select[bet]+ "に賭けました。");
        System.out.println("ルーレット開始！");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
        }
        System.out.println("今回選ばれた数字は"+ result + "です。");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        System.out.println("");
        int resultMoney = 0;
        if (bet == 0) {
            if (result % 2 ==0) {
                resultMoney = betMoney * 2;
                System.out.println("あなたの勝ちです！");
            } else {
                resultMoney = 0;
                System.out.println("あなたは負けてしまいました。");

            }
        } else if (bet == 1) {
            if (result % 2 == 0) {
                resultMoney = 0;
                System.out.println("あなたは負けてしまいました。");
            } else {
                resultMoney = betMoney * 2;
                System.out.println("あなたの勝ちです！");
            }
        }
        System.out.println("掛け金"+ betMoney+ "円は、"+ resultMoney + "円になりました。");
        nowMoney += resultMoney;
        System.out.println("あなたの現在の所持金は"+ nowMoney + "円です。");
        u.setMoney(nowMoney);
        if (nowMoney > 0) {
            this.again(u);
        } else  {
            System.out.println("所持金がなくなってしまったので、これ以上ゲームを続けることはできません。");
            this.quip(u);
        }

    }
    void again(User u) {
        while (true) {
            System.out.println("-------------------");
            System.out.println("もう一度やりますか？");
            System.out.println("0. やる");
            System.out.println("1. やらない");
            System.out.print("番号を入力してください：");
            int again = new java.util.Scanner(System.in).nextInt();
            if  (again ==0 || again==1) {
                if (again == 1) {
                    this.quip(u);
                } else if (again == 0){
                    this.casino(u);
                }
                break;
            } else {
                System.out.println("");
                System.out.println("[エラー]");
                System.out.println("正しい番号を入力してください。");
                System.out.println("-------------------");
            }
        }
    }
    void quip(User u) {
        System.out.println("-------------------");
        System.out.println("お疲れ様でした！");
    }
}
