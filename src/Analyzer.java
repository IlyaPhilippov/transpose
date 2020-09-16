public class Analyzer {
    private String[] args;
    private String wordsize;
    private String inputname = null;
    private String outputname = null;
    private boolean tStatus = false;
    private boolean rStatus = false;


    public Analyzer (String[] args){
        this.args = args;
    }

    public void analise(){
        if (args.length > 7)
            throw new IllegalArgumentException("Error");
        int i;
        for ( i = 0; i < args.length; i++){
            switch (args[i]){
                case "-a":
                    wordsize = args[i + 1];
                    i++;
                    break;
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
                    inputname = args[i];
            }
        }
        if ((wordsize == null) && (!tStatus) && (!rStatus)){
            throw new IllegalArgumentException("Error");
        }
        if ((wordsize == null) && ((rStatus) || (tStatus))){
            wordsize = "10";
        }

    }
    public String getInputname (){
        return inputname;
    }
    public String getOutputname (){
        return outputname;
    }
    public String getWordsize (){
        return wordsize;
    }
    public boolean getrStatus (){
        return rStatus;
    }
    public boolean gettStatus (){
        return tStatus;
    }
}
