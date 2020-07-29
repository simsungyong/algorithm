package SocarHome;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class bombGame extends JFrame {

    boolean isEnd;
    HashSet<Integer> set;
    Queue<State> bomb_info;
    Random random =	new Random();
    Box[][] bomb;
    JButton button[][];
    JMenuBar mb = new JMenuBar();
    JMenu menu = new JMenu("메뉴");


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        new bombGame();


    }

    public bombGame() {
        super("지뢰찾기_심성용");
        set = new HashSet<>();
        bomb_info = new LinkedList<>();
        bomb =new Box[10][10];

        for(int i=0; i<10; i++){
            for(int k=0; k<10; k++){
                bomb[i][k] = new Box(0,false);
            }
        }

        button = new JButton[10][10];

        //새로운 게임과 종료로 메뉴를 구성하였습니
        menu.add(new JMenuItem("새 게임")).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { dispose();	new bombGame();	} });

        menu.add(new JMenuItem("종료")).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {System.exit(0);} });

        mb.add(menu);
        this.setJMenuBar(mb);

        GridLayout grid = new GridLayout(10,10);
        setLayout(grid);


        while (set.size() < 10){      //-----------------------중복없는 난수를 위해 HashSet을 이용하였습니다.

            int random_num  = random.nextInt(10*10);     //난수 생성
            set.add(random_num);
        }

        int x = 0;
        int y = 0;

        for(int tmp : set){           //뽑아낸 난수를 이용하여 지뢰를 지정합니다.
            x = tmp/10;
            y = tmp%10;
            bomb[x][y].value = 9;
            bomb_info.add(new State(x,y));
        }
            //-------------------------------------버튼 생성-------------------------

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(bomb[i][j].value == 0) {         //지뢰가 아닌 사각형일 때 버튼생성과, 이벤트리스너 생성 부분입니다.
                    button[i][j] = new JButton("");
                    button[i][j].addActionListener(new ButtonListener());
                    button[i][j].addMouseListener(new clickListener());
                    add(button[i][j]);
                }
                else if(bomb[i][j].value != 0) {    //지뢰인 사각형일 때 버튼생성과, 이벤트리스너 생성 부분입니다.
                    button[i][j] = new JButton("");
                    button[i][j].addActionListener(new MineListener());
                    button[i][j].addMouseListener(new clickListener());
                    add(button[i][j]);
                }
            }
        }

        //---------------------------------------정보 업데이트------------------------------------------

        while(!bomb_info.isEmpty()){    //지뢰의 좌표가 저장된 큐에서 하나씩 빼내와 탐색합니다.

            State cnt_bomb = bomb_info.poll();

            for(int aroundX=-1; aroundX <2; aroundX++) {    //주변 8개의 칸을 탐색합니다.
                for (int aroundY = -1; aroundY < 2; aroundY++) {
                    if( aroundX== 0 && aroundY==0 ){        //자기 자신은 탐색하지않습니다.
                        continue;
                    }

                    if(cnt_bomb.x+aroundX>=0 && cnt_bomb.x+aroundX<10 && cnt_bomb.y+aroundY >=0 && cnt_bomb.y+aroundY < 10){ //좌표의 상하 범위를 체크합니다.
                        if(bomb[cnt_bomb.x+aroundX][cnt_bomb.y+aroundY].value!=9){ //폭탄인 자리는 다른 주변지뢰의 정보를 표시하지 않습니다.
                            bomb[cnt_bomb.x+aroundX][cnt_bomb.y+aroundY].value++;
                        }
                    }
                }
            }
        }


        isEnd = false;
        setVisible(true);
        setSize(500, 500);
        this.setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

//----------------------------------------지뢰가 아닌 버튼을 눌렸을 때 실행되는 이벤트리스너입니다-----------------------------
    private class ButtonListener implements ActionListener  {
        public void actionPerformed(ActionEvent e) {
                out: for(int i = 0; i < 10; i++) {
                    for(int k = 0; k < 10; k++) {
                        if(e.getSource() == button[i][k] && !bomb[i][k].isCheck) {  //그전에 방문한 사각형인지 확인을 한 후, 탐색을 시작합니다.
                            bomb[i][k].isCheck = true;
                            check(i, k);
                            break out;
                        }
                    }
                }

                victory();  //클릭한 버튼을 통하여 깊이 탐색을 끝낸 후 게임이 종료되었는지 확인합니다.



        }
    }
//-----------------------------------------------지뢰인 사각형을 클릭했을 때, 게임을 종료하고 모든 정보를 보여주는 이벤트리스너입니다----------------------------
    private class MineListener implements ActionListener  {
        public void actionPerformed(ActionEvent e) {

            if(!isEnd) {
                JOptionPane.showMessageDialog(null, "실패하였습니다");

            }

            for(int i = 0; i < 10; i++) {
                for(int k = 0; k < 10; k++) {
                    if(bomb[i][k].value == 9) {
                        button[i][k].setText("지뢰");
                        button[i][k].setForeground(Color.RED);
                        isEnd=true;
                    }else{
                        button[i][k].setText(String.valueOf(bomb[i][k].value));
                    }
                }
            }



        }
    }

//-----------------------------------------마우스 오른쪽 버튼으로 지뢰를 지정하는 마우스리스너입니다---------------------------------
    private class clickListener implements MouseListener{

        public void mouseClicked(MouseEvent e) {

        }

        public void mousePressed(MouseEvent e) {
                if(e.getModifiersEx() == InputEvent.BUTTON3_DOWN_MASK) {
                    for(int i = 0; i<10; i++) {
                        for(int k = 0; k<10; k++) {
                            if(e.getSource() == button[i][k] && !bomb[i][k].isCheck) {
                                button[i][k].setText("지뢰");
                                button[i][k].setForeground(Color.RED);
                                bomb[i][k].isCheck = true;
                                victory();      //마지막 지뢰인지 확인합니다.
                            }
                            else if(e.getSource() == button[i][k] && bomb[i][k].isCheck) {
                                button[i][k].setText("");
                                button[i][k].setForeground(Color.BLACK);
                                bomb[i][k].isCheck = false;
                            }
                        }
                    }
                }


        }

        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub

        }
    }

    //--------------------------------------------주변의 지뢰 갯수가 0일 때, 깊이 탐색으로 이어져있는 사각형을 방문하는 메서드입니다.---------------------------
    private void check(int i, int k) {

            if (bomb[i][k].value == 0) {
                button[i][k].setText("0");
                for (int aroundX = -1; aroundX < 2; aroundX++) {    //주변 8개의 칸을 탐색합니다.
                    for (int aroundY = -1; aroundY < 2; aroundY++) {
                        int nextX = i + aroundX;
                        int nextY = k + aroundY;
                        if(nextX >=0 && nextX <10 && nextY >=0 && nextY <10){       //인덱스범위를 체크합니다.
                            if(!bomb[nextX][nextY].isCheck ){
                                bomb[nextX][nextY].isCheck = true;
                                check(nextX,nextY);
                            }
                        }

                    }

                }
            }else{ //주변의 지뢰 갯수가 0이 아닐 경우에는 버튼의 텍스트만 변경해줍니다
                button[i][k].setText(String.valueOf(bomb[i][k].value));
            }

    }

//------------------------------------------게임이 끝났는지 확인하는 메서드입니다-----------------------------------
    private void victory() {

            int count = 0;      //지뢰가 아닌 사각형 중, 탐색을 완료한 사각형 갯수입니다.
            int bombnum = 0;    //예상한 지뢰 갯수입니다.

            for(int i=0; i<10; i++) {
                for(int k=0; k<10; k++) {
                    if(this.bomb[i][k].value != 9 && this.bomb[i][k].isCheck) {
                        count++;
                    }
                    else if(this.bomb[i][k].value == 9 && this.bomb[i][k].isCheck){
                        bombnum++;
                    }
                }
            }
            System.out.print(count+" "+bombnum);

            if(count == 90 && bombnum==10 ) {  //모든 사각형을 방문했고, 지뢰의 갯수도 정확할 때, 게임을 종료합니다

                if(!isEnd) {
                    JOptionPane.showMessageDialog(null, "성공!");
                    isEnd = true;
                }

        }


    }

}
class State{
    int x,y;
    State(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Box{
    int value;
    boolean isCheck;
    Box(int value, boolean isCheck){
        this.value = value;
        this.isCheck = isCheck;
    }
}