package com.djunderworld.nongjik.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QStoryComment is a Querydsl query type for StoryComment
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QStoryComment extends EntityPathBase<StoryComment> {

    private static final long serialVersionUID = 732365624L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoryComment storyComment = new QStoryComment("storyComment");

    public final QBase _super = new QBase(this);

    public final StringPath content = createString("content");

    //inherited
    public final StringPath createdAt = _super.createdAt;

    public final NumberPath<Long> depth = createNumber("depth", Long.class);

    public final NumberPath<Long> groupId = createNumber("groupId", Long.class);

    public final NumberPath<Long> groupIdCount = createNumber("groupIdCount", Long.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Long> position = createNumber("position", Long.class);

    public final QStory story;

    //inherited
    public final StringPath updatedAt = _super.updatedAt;

    public final QUser user;

    public QStoryComment(String variable) {
        this(StoryComment.class, forVariable(variable), INITS);
    }

    public QStoryComment(Path<? extends StoryComment> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QStoryComment(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QStoryComment(PathMetadata<?> metadata, PathInits inits) {
        this(StoryComment.class, metadata, inits);
    }

    public QStoryComment(Class<? extends StoryComment> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.story = inits.isInitialized("story") ? new QStory(forProperty("story"), inits.get("story")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

