package hoimsys.po;

public class Title {
    private Integer tId;

    private String tName;

    private Long tFee;

    private String tRemark;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    public Long gettFee() {
        return tFee;
    }

    public void settFee(Long tFee) {
        this.tFee = tFee;
    }

    public String gettRemark() {
        return tRemark;
    }

    public void settRemark(String tRemark) {
        this.tRemark = tRemark == null ? null : tRemark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tId=").append(tId);
        sb.append(", tName=").append(tName);
        sb.append(", tFee=").append(tFee);
        sb.append(", tRemark=").append(tRemark);
        sb.append("]");
        return sb.toString();
    }
}