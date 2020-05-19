package module3;

import java.util.*;


public class CardGame {
    private List<Card> list = new ArrayList<>();
    private List<Card> restCard = new ArrayList<>();
    private String landlord;
    private List<Card> player1;
    private List<Card> player2;
    private List<Card> player3;

    public CardGame() {
        this.list = initialCard();
        this.player1 = new ArrayList<>();
        this.player2 = new ArrayList<>();
        this.player3 = new ArrayList<>();
        this.restCard = new ArrayList<>();
        this.landlord = "";
    }

    //初始化54张卡牌 将牌放入list
    public List<Card> initialCard(){
        for(String s : Card.colorsOption){
            for(String i : Card.cardNum){
                //不放入大小王
                if(i.equals("大王") || i.equals("小王")){
                    continue;
                }
                Card card = new Card(s,i);
                list.add(card);
            }
        }
        list.add(new Card(null, "大王"));
        list.add(new Card(null, "小王"));
        shuffle();
        return list;
    }

    //打乱list
    private void shuffle(){
        Collections.shuffle(list);
    }

    //将牌发给每个player
    public void deal(){
        List<List<Card>> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        for(int i = 0;i < list.size() ;i++){
            //最后三张牌
            if(i >=list.size()-3){
                restCard.add(list.get(i));
            }else{
                //通过三的余数 分别发牌
                playerList.get(i%3).add(list.get(i));
            }
        }
        //通过卡牌在list顺序 作为comparator 排序标准
        Comparator<Card> comparator = new Comparator<Card>(){
            @Override
            public int compare(Card o1, Card o2) {
                int result = Card.cardNum.indexOf(o1.getNumber()) - Card.cardNum.indexOf((o2.getNumber()));
                return result != 0 ? result: Card.colorsOption.indexOf(o1.getColor()) - Card.colorsOption.indexOf((o2.getColor()));
            }
        };
        Random r = new Random();
        int num = r.nextInt(2);
        playerList.get(num).addAll(restCard);
        //都通过comparator 排序
        player1.sort(comparator);
        player2.sort(comparator);
        player3.sort(comparator);

        if(player1.size() > player2.size() && player1.size() > player3.size()){
            landlord = "玩家1";
        }else if(player2.size() > player3.size()){
            landlord = "玩家2";
        }else{
            landlord = "玩家3";
        }
    }

    public void show(){
        //打印玩家
        System.out.println("玩家1：" + player1);
        System.out.println("玩家2：" + player2);
        System.out.println("玩家3：" + player3);
        System.out.println("底牌：" + restCard + "，" + landlord + " 获得地主");
    }

    public static void main(String[] args) {
        CardGame cardGame = new CardGame();
        cardGame.deal();
        cardGame.show();
    }

}
