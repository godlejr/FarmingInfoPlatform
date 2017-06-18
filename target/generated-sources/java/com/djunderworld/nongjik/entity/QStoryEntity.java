package com.djunderworld.nongjik.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QStoryEntity is a Querydsl query type for StoryEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QStoryEntity extends EntityPathBase<StoryEntity> {

    private static final long serialVersionUID = -1859498006L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoryEntity storyEntity = new QStoryEntity("storyEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final StringPath createdAt = _super.createdAt;

    public final ListPath<FileEntity, QFileEntity> fileEntities = this.<FileEntity, QFileEntity>createList("fileEntities", FileEntity.class, QFileEntity.class, PathInits.DIRECT2);

    public final NumberPath<Integer> hits = createNumber("hits", Integer.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QItemCategoryEntity itemCategoryEntity;

    public final StringPath title = createString("title");

    //inherited
    public final StringPath updatedAt = _super.updatedAt;

    public final QUserEntity userEntity;

    public QStoryEntity(String variable) {
        this(StoryEntity.class, forVariable(variable), INITS);
    }

    public QStoryEntity(Path<? extends StoryEntity> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QStoryEntity(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QStoryEntity(PathMetadata<?> metadata, PathInits inits) {
        this(StoryEntity.class, metadata, inits);
    }

    public QStoryEntity(Class<? extends StoryEntity> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.itemCategoryEntity = inits.isInitialized("itemCategoryEntity") ? new QItemCategoryEntity(forProperty("itemCategoryEntity"), inits.get("itemCategoryEntity")) : null;
        this.userEntity = inits.isInitialized("userEntity") ? new QUserEntity(forProperty("userEntity"), inits.get("userEntity")) : null;
    }

}

