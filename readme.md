# Personal Blog 
    @PostMapping("refresh/{refreshToken}")
    @ApiOperation("Refreshes token")
    @CacheLock(autoDelete = false)
    public AuthToken refresh(@PathVariable("refreshToken") String refreshToken) {
        return adminService.refreshToken(refreshToken);

    @PostMapping("login")
    @ApiOperation("Login")
    @CacheLock(autoDelete = false)
    public AuthToken auth(@RequestBody @Valid LoginParam loginParam) {
        return adminService.authenticate(loginParam);
    }
    
    @PutMapping("{attachmentId:\\d+}")
        @ApiOperation("Updates a attachment")
        public AttachmentDTO updateBy(@PathVariable("attachmentId") Integer attachmentId,
                                      @RequestBody @Valid AttachmentParam attachmentParam) {
            Attachment attachment = attachmentService.getById(attachmentId);
            attachmentParam.update(attachment);
            return new AttachmentDTO().convertFrom(attachmentService.update(attachment));
        }