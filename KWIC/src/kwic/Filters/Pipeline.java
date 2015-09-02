package kwic.Filters;

public class Pipeline {
    
    private final Filter[] filters;
    
    public Pipeline(Filter ... filters) {
        this.filters = filters;
        for (int i = 0; i < filters.length-1; i++) {
            Pipe p = new Pipe();
            filters[i].setOutputPipe(p);
            filters[i+1].setInputPipe(p);
        }
    }
    
    public void initialize() {
        for (Filter f: filters) {
            new Thread(f).start();
        }
    }
}
