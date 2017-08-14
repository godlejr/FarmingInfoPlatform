package com.djunderworld.nongjik.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -497230503L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final QBase _super = new QBase(this);

    public final StringPath avatar = createString("avatar");

    public final StringPath cover = createString("cover");

    //inherited
    public final StringPath createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final ListPath<UserFollower, QUserFollower> followerUsers = this.<UserFollower, QUserFollower>createList("followerUsers", UserFollower.class, QUserFollower.class, PathInits.DIRECT2);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Integer> level = createNumber("level", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final QProfessional professional;

    public final ListPath<Story, QStory> stories = this.<Story, QStory>createList("stories", Story.class, QStory.class, PathInits.DIRECT2);

    public final ListPath<StoryComment, QStoryComment> storyComments = this.<StoryComment, QStoryComment>createList("storyComments", StoryComment.class, QStoryComment.class, PathInits.DIRECT2);

    public final ListPath<StoryLike, QStoryLike> storyLikes = this.<StoryLike, QStoryLike>createList("storyLikes", StoryLike.class, QStoryLike.class, PathInits.DIRECT2);

    public final ListPath<StoryScrap, QStoryScrap> storyScraps = this.<StoryScrap, QStoryScrap>createList("storyScraps", StoryScrap.class, QStoryScrap.class, PathInits.DIRECT2);

    //inherited
    public final StringPath updatedAt = _super.updatedAt;

    public final ListPath<UserFollower, QUserFollower> userFollowers = this.<UserFollower, QUserFollower>createList("userFollowers", UserFollower.class, QUserFollower.class, PathInits.DIRECT2);

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUser(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUser(PathMetadata<?> metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.professional = inits.isInitialized("professional") ? new QProfessional(forProperty("professional"), inits.get("professional")) : null;
    }

}

