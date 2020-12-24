package com.sys.demo01.pojo;

import lombok.Data;

@Data
public class TreeDataResult {
    private long id;//节点ID，对加载远程数据很重要。
    private String text;//显示节点文本。
    private String state;//节点状态，'open' 或 'closed'，默认：'open'。如果为'closed'的时候，将不自动展开该节点。
    private String checked;//表示该节点是否被选中。
    private long parentId;//上级id

    public TreeDataResult(long id, String text, String state, String checked, long parentId) {
        super();
        this.id = id;
        this.text = text;
        this.state = state;
        this.checked = checked;
        this.parentId = parentId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
}
