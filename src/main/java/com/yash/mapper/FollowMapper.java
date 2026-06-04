package com.yash.mapper;




import com.yash.dto.FollowResponseDTO;

import com.yash.entity.Follow;
import com.yash.entity.User;

public class FollowMapper {

    public static Follow toEntity(User follower, User following) {
    	Follow follow = new Follow();
    	follow.setFollower(follower);
    	follow.setFollowing(following);
        return follow;
    }

    public static FollowResponseDTO toDTO(Follow follow) {

    	FollowResponseDTO dto = new FollowResponseDTO();
        dto.setId(follow.getId());
        dto.setFollower(UserMapper.toDto(follow.getFollower()));
        dto.setFollowing(UserMapper.toDto(follow.getFollowing()));
        dto.setTime(follow.getTime());

        return dto;
    }
}