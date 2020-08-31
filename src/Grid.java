public class Grid {
    private int l,w;
    private double p;
    boolean[][] grid_state;

    public Grid(int l,int w, double p){
        this.l=l;
        this.w=w;
        this.p=p;
        grid_state=new boolean[l][w];
        nextState();
    }

    public void nextState()
    {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                if(Math.random() < p)
                {
                    grid_state[i][j]=true;
                }
                else
                {
                    grid_state[i][j]=false;
                }
            }
        }
    }

    public boolean getCellState(int x,int y)
    {
        return grid_state[x][y];
    }

}
