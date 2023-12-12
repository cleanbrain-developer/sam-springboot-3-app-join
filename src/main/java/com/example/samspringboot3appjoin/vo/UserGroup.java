package com.example.samspringboot3appjoin.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * <pre>
 * User: clean_brain
 * Date: 2023-12-12
 * Comments:
 * </pre>
 */
@AllArgsConstructor
@Getter
@ToString
public class UserGroup {
    private long userId;
    private String userName;
    private long groupId;
    private String groupName;

    @Override
    public String toString() {
        return "UserGroup{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                "}\n";
    }
}
