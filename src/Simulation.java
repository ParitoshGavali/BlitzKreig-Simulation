import java.io.FileWriter;
import com.opencsv.CSVWriter;

public class Simulation {
    final static int length=1000;
    public static void main(String[] args) throws Exception
    {
        CSVWriter writer=new CSVWriter(new FileWriter("data.csv"));
        writer.writeNext(new String[]{"p","w","t"});
        for(double p = 0.05; p < 0.9; p=p+0.05)
        {
            for(int w=2;w<50;w++)
            {
                Clock clock=new Clock();
                Grid grid = new Grid(length,w,p);
                Infiltrator infiltrator=new Infiltrator();
                while(infiltrator.y==-1)
                {
                    for (int i = 1; i < length - 1; i++)
                    {
                        if (!grid.getCellState(i, 0))
                        {
                            infiltrator.x = i;
                            infiltrator.y = 0;
                            break;
                        }
                    }
                    if(infiltrator.y==-1)
                    {
                        if(!grid.getCellState(0,0))
                        {
                            infiltrator.x=0;
                            infiltrator.y=0;
                        }
                        else if(!grid.getCellState(0,length-1))
                        {
                            infiltrator.x=length-1;
                            infiltrator.y=0;
                        }
                    }
                    grid.nextState();
                    clock.incrementT();
                }
                while(infiltrator.y!=w-1)
                {
                    if(!grid.getCellState(infiltrator.x,infiltrator.y))
                    {
                        if(!grid.getCellState(infiltrator.x,infiltrator.y+1))
                        {
                            infiltrator.y++;
                        }
                        else if(infiltrator.x > 1 && !grid.getCellState(infiltrator.x-1,infiltrator.y+1))
                        {
                            infiltrator.y++;
                            infiltrator.x--;
                        }
                        else if(infiltrator.x<length-1 && !grid.getCellState(infiltrator.x+1,infiltrator.y+1))
                        {
                            infiltrator.y++;
                            infiltrator.x++;
                        }
                    }
                    grid.nextState();
                    clock.incrementT();
                }
                writer.writeNext(new String[]{String.valueOf(p), String.valueOf(w), String.valueOf(clock.getT())});

            }
        }
        writer.flush();
    }
}
