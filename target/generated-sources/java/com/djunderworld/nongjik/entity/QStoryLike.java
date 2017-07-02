package com.djunderworld.nongjik.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QStoryLike is a Querydsl query type for StoryLike
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QStoryLike extends EntityPathBase<StoryLike> {

    private static final long serialVersionUID = 1160278366L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoryLike storyLike = new QStoryLike("storyLike");

    public final QBase _super = new QBase(this);

    //inherited
    public final StringPath createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QStory story;

    //inherited
    public final StringPath updatedAt = _super.updatedAt;

    public final QUser user;

    public QStoryLike(String variable) {
        this(StoryLike.class, forVariable(variable), INITS);
    }

    public QStoryLike(Path<? extends StoryLike> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QStoryLike(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QStoryLike(PathMetadata<?> metadata, PathInits inits) {
        this(StoryLike.class, metadata, inits);
    }

    public QStoryLike(Class<? extends StoryLike> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.story = inits.isInitialized("story") ? new QStory(forProperty("story"), inits.get("story")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

