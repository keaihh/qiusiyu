package com.fc.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fc.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserVo{
    private Integer id;
    private String username;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastAccessTime;
}
