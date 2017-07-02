package com.djunderworld.nongjik.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QStoryScrap is a Querydsl query type for StoryScrap
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QStoryScrap extends EntityPathBase<StoryScrap> {

    private static final long serialVersionUID = 1615183594L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoryScrap storyScrap = new QStoryScrap("storyScrap");

    public final QBase _super = new QBase(this);

    //inherited
    public final StringPath createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QStory story;

    //inherited
    public final StringPath updatedAt = _super.updatedAt;

    public final QUser user;

    public QStoryScrap(String variable) {
        this(StoryScrap.class, forVariable(variable), INITS);
    }

    public QStoryScrap(Path<? extends StoryScrap> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QStoryScrap(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QStoryScrap(PathMetadata<?> metadata, PathInits inits) {
        this(StoryScrap.class, metadata, inits);
    }

    public QStoryScrap(Class<? extends StoryScrap> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.story = inits.isInitialized("story") ? new QStory(forProperty("story"), inits.get("story")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

