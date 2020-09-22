public class Analyzer {
    private String[] args;
    private Integer wordsize = null;
    private String inputname = null;
    private String outputname = null;
    private boolean tStatus = false;
    private boolean rStatus = false;


    public Analyzer (String[] args){
        this.args = args;
    }

    public void analise(){
        int i;
        for ( i = 0; i < args.length; i++){
            switch (args[i]){
                case "-a":
                    try {
                        wordsize = Integer.parseInt(args[i + 1]);
                        i++;
                        break;
                    } catch(NumberFormatException e) {
                        throw new IllegalArgumentException("Incorrect word size!");
                    }
                case "-r":
                    rStatus = true;
                    break;
                case "-t":
                    tStatus = true;
                    break;
                case "-o":
                    outputname = args[i + 1];
                    i++;
                    break;
                default:
                    if(inputname == null) {
                        inputname = args[i];
                    } else throw new IllegalArgumentException("Too much arguments!");
            }
        }
        if ((wordsize == null ) && ((rStatus) || (tStatus))){
            wordsize = 10;
        }

    }
    public String getInputname (){
        return inputname;
    }
    public String getOutputname (){
        return outputname;
    }
    public Integer getWordsize (){
        return wordsize;
    }
    public boolean getrStatus (){
        return rStatus;
    }
    public boolean gettStatus (){
        return tStatus;
    }
}