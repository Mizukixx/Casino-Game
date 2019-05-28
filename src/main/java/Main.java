public class Main {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
        User u = new User();
        System.out.print("あなたの名前を入力してください：");
        String name = new java.util.Scanner(System.in).nextLine();
        u.setName(name);
        Play p = new Play();
        System.out.println("-------------------");
        System.out.println("カジノゲーム");
        System.out.println("ようこそ、"+ u.getName() + "さん");
        System.out.println("これから、１〜１００までの数字が書かれたルーレットを回します。");
        System.out.println("偶数は赤で、奇数は白で塗られています。");
        System.out.println("赤か白のどちらかに賭けて所持金を増やしましょう。");

        System.out.println("-------------------");
        System.out.println("");

        p.casino(u);
    }
}
