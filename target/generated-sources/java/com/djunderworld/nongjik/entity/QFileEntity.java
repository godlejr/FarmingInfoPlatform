package com.djunderworld.nongjik.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QFileEntity is a Querydsl query type for FileEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QFileEntity extends EntityPathBase<FileEntity> {

    private static final long serialVersionUID = 1527629709L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFileEntity fileEntity = new QFileEntity("fileEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdAt = _super.createdAt;

    public final StringPath ext = createString("ext");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final NumberPath<Integer> size = createNumber("size", Integer.class);

    public final QStoryEntity storyEntity;

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    //inherited
    public final StringPath updatedAt = _super.updatedAt;

    public QFileEntity(String variable) {
        this(FileEntity.class, forVariable(variable), INITS);
    }

    public QFileEntity(Path<? extends FileEntity> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QFileEntity(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QFileEntity(PathMetadata<?> metadata, PathInits inits) {
        this(FileEntity.class, metadata, inits);
    }

    public QFileEntity(Class<? extends FileEntity> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.storyEntity = inits.isInitialized("storyEntity") ? new QStoryEntity(forProperty("storyEntity"), inits.get("storyEntity")) : null;
    }

}

