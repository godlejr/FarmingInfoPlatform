package com.djunderworld.nongjik.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QStory is a Querydsl query type for Story
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QStory extends EntityPathBase<Story> {

    private static final long serialVersionUID = 1763916071L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStory story = new QStory("story");

    public final QBase _super = new QBase(this);

    public final StringPath content = createString("content");

    //inherited
    public final StringPath createdAt = _super.createdAt;

    public final ListPath<File, QFile> files = this.<File, QFile>createList("files", File.class, QFile.class, PathInits.DIRECT2);

    public final NumberPath<Integer> hits = createNumber("hits", Integer.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QItemCategory itemCategory;

    public final ListPath<StoryComment, QStoryComment> storyComments = this.<StoryComment, QStoryComment>createList("storyComments", StoryComment.class, QStoryComment.class, PathInits.DIRECT2);

    public final ListPath<StoryLike, QStoryLike> storyLikes = this.<StoryLike, QStoryLike>createList("storyLikes", StoryLike.class, QStoryLike.class, PathInits.DIRECT2);

    public final ListPath<StoryScrap, QStoryScrap> storyScraps = this.<StoryScrap, QStoryScrap>createList("storyScraps", StoryScrap.class, QStoryScrap.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    //inherited
    public final StringPath updatedAt = _super.updatedAt;

    public final QUser user;

    public QStory(String variable) {
        this(Story.class, forVariable(variable), INITS);
    }

    public QStory(Path<? extends Story> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QStory(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QStory(PathMetadata<?> metadata, PathInits inits) {
        this(Story.class, metadata, inits);
    }

    public QStory(Class<? extends Story> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.itemCategory = inits.isInitialized("itemCategory") ? new QItemCategory(forProperty("itemCategory"), inits.get("itemCategory")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

