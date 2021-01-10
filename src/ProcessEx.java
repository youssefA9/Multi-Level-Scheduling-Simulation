public class ProcessEx {

    protected int beginTime;
    protected int endTime;
    protected Process p;

    public ProcessEx() {

    }

    public ProcessEx(int btime, int etime, Process p) {

        this.beginTime = btime;
        this.endTime = etime;
        this.p = p;

    }

    public int getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(int beginTime) {
        this.beginTime = beginTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public Process getP() {
        return p;
    }

    public void setP(Process p) {
        this.p = p;
    }
}
