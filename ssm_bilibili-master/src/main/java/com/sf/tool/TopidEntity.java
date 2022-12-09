package com.sf.tool;


import com.sf.entity.VideoTopicEntity;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TopidEntity implements RowMapper<VideoTopicEntity> {

    public VideoTopicEntity mapRow(ResultSet arg0, int arg1) throws SQLException {
       VideoTopicEntity video = new VideoTopicEntity();
        video.setVideoid(arg0.getInt("videoid"));
        video.setVideoName(arg0.getString("videoName"));


        return video;
    }

}
