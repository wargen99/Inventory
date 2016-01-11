/*jQuery(document)
		.ready(
				function() {
					Core.init();

					if ($(".select2-single").length != 0) {

						$(".select2-single").select2();
					}
					
					$(".login-button").click(function(){
						document.location.href = "login.html";
					});

					$("#project_create_btn").click(function() {
						document.location.href = "project_wizard.html";
					});

					$(".project-list tr").click(function() {
						document.location.href = "project_info.html";
					});

					if ($("body.main").length != 0) {
						$('.center-mode').slick({
							dots : true,
							centerMode : true,
							centerPadding : '60px',
							slidesToShow : 3,
							initialSlide: 1,
							responsive : [ {
								breakpoint : 768,
								settings : {
									arrows : false,
									centerMode : true,
									centerPadding : '40px',
									slidesToShow : 3
								}
							}, {
								breakpoint : 480,
								settings : {
									arrows : false,
									centerMode : true,
									centerPadding : '40px',
									slidesToShow : 1
								}
							} ]
						});

						$(".jumbo-slick").slick({
							dots : false,
							centerMode : false,
							arrows : false,
							autoplay : true,
							autoplaySpeed : 2500
							
						});
					}

					if ($("body.dashboard").length != 0) {
						$('#high-line3')
								.highcharts(
										{
											title : {
												text : '',
												x : -20
											// center
											},

											xAxis : {
												categories : [ 'Jan', 'Feb',
														'Mar', 'Apr', 'May',
														'Jun', 'Jul', 'Aug',
														'Sep', 'Oct', 'Nov',
														'Dec' ]
											},
											yAxis : {
												title : {
													text : ''
												},
												plotLines : [ {
													value : 0,
													width : 1,
													color : '#808080'
												} ]
											},
											tooltip : {
												valueSuffix : '%'
											},
											legend : {
												layout : 'vertical',
												align : 'right',
												verticalAlign : 'middle',
												borderWidth : 0
											},
											series : [
													{
														name : '남자',
														data : [ 7.0, 6.9, 9.5,
																14.5, 18.2,
																21.5, 25.2,
																26.5, 23.3,
																18.3, 13.9, 9.6 ],
														color : "blue"
													},
													{
														name : '여자',
														data : [ -0.2, 0.8,
																5.7, 11.3,
																17.0, 22.0,
																24.8, 24.1,
																20.1, 14.1,
																8.6, 2.5 ],
														color : "skyblue"
													},
													{
														name : '미성년자',
														data : [ -0.9, 0.6,
																3.5, 8.4, 13.5,
																17.0, 18.6,
																17.9, 14.3,
																9.0, 3.9, 1.0 ],
														color : "orange"
													} ]
										});

						$('#high-column')
								.highcharts(
										{
											chart : {
												type : 'column'
											},

											title : {
												text : ''
											},

											xAxis : {
												categories : [

												],
												crosshair : true
											},
											yAxis : {
												min : 0,
												title : {
													text : '도달율 (%)'
												}
											},
											tooltip : {
												headerFormat : '<table>',
												pointFormat : '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
														+ '<td style="padding:0"><b>{point.y:.1f} %</b></td></tr>',
												footerFormat : '</table>',
												shared : true,
												useHTML : true
											},
											plotOptions : {
												column : {
													pointPadding : 0.2,
													borderWidth : 0
												}
											},
											series : [ {
												name : '네이버 블로그',
												data : [ 24 ],
												color : "orange"
											}, {
												name : 'Twitter',
												data : [ 7 ],
												color : "skyblue"
											}, {
												name : 'Facebook',
												data : [ 14 ],
												color : "blue"
											}, {
												name : '다음 카페',
												data : [ 21 ],
												color : "purple"
											} ]
										});

						$('#high-bars').highcharts(
								{
									chart : {
										type : 'bar'
									},
									title : {
										text : ''
									},

									xAxis : {
										categories : [
												'LARVA 배터리충전팩 AAA형 - 실버',
												'Rubber Duck 블루투스 스피커' ],
										title : {
											text : null
										}
									},
									yAxis : {
										min : 0,
										title : {
											text : '진행도 (%)'
										},
										labels : {
											overflow : 'justify'
										},
										max : 100
									},
									tooltip : {
										valueSuffix : ' %'
									},
									plotOptions : {
										bar : {
											dataLabels : {
												enabled : true
											}
										}
									},
									legend : {
										layout : 'vertical',
										x : -40,
										y : 80,

									},
									credits : {
										enabled : false
									},
									series : [ {
										name : '계획도 (%)',
										data : [ 100, 25 ],
										color : "orange"
									}, {
										name : '진행도 (%)',
										data : [ 75, 0 ],
										color : "green"
									} ]
								});
					}

					if ($("body.project-info").length != 0) {
						$("#tree")
								.fancytree(
										{
											icons : false, // Display node
											// icons.
											clickFolderMode : 3, // 1:activate,
											// 2:expand,
											// 3:activate and expand,
											// 4:activate (dblclick
											// expands)

											activate : function(event, data) {
												var node = data.node;
												// acces node attributes
												if (node.title.toLowerCase()
														.indexOf("front_cover") != -1) {
													var pdmInputs = $(".pdm_bom input");
													pdmInputs.eq(0).attr(
															"value",
															"FRONT_COVER");
													pdmInputs.eq(1).attr(
															"value", "1");
													pdmInputs.eq(2).attr(
															"value",
															"FRONT COVER");
													pdmInputs
															.eq(3)
															.attr("value",
																	"LARVA 배터리충전팩 AAA형 - 실버");
													pdmInputs.eq(4).attr(
															"value", "COVER");
													pdmInputs.eq(5).attr(
															"value", "MM");
													pdmInputs.eq(6).attr(
															"value", "하창수");
													pdmInputs.eq(7).attr(
															"value", "하창수");
													pdmInputs.eq(8).attr(
															"value",
															"2015.09.01");
													pdmInputs.eq(9).attr(
															"value", "working");
												}

											},
										});
					}

					if ($("body.project-wizard").length != 0) {

						"use strict";

						// Init Theme Core

						// Init Demo JS

						// Form Wizard
						var form = $("#form-wizard");
						form.validate({
							errorPlacement : function errorPlacement(error,
									element) {
								element.before(error);
							},
							rules : {
								confirm : {
									equalTo : "#password"
								}
							}
						});

						form
								.children(".wizard")
								.steps(
										{
											headerTag : ".wizard-section-title",
											bodyTag : ".wizard-section",
											onStepChanging : function(event,
													currentIndex, newIndex) {
												form.validate().settings.ignore = ":disabled,:hidden";
												return form.valid();
											},
											onFinishing : function(event,
													currentIndex) {
												form.validate().settings.ignore = ":disabled";
												return form.valid();
											},
											onFinished : function(event,
													currentIndex) {
												alert("Submitted!");
											}
										});

						// Demo Wizard Functionality
						var formWizard = $('.wizard');
						var formSteps = formWizard.find('.steps');

						$('.wizard-options .holder-style')
								.on(
										'click',
										function(e) {
											e.preventDefault();

											var stepStyle = $(this).data(
													'steps-style');

											var stepRight = $('.holder-style[data-steps-style="steps-right"]');
											var stepLeft = $('.holder-style[data-steps-style="steps-left"]');
											var stepJustified = $('.holder-style[data-steps-style="steps-justified"]');

											if (stepStyle === "steps-left") {
												stepRight
														.removeClass('holder-active');
												stepJustified
														.removeClass('holder-active');
												formWizard
														.removeClass('steps-right steps-justified');
											}
											if (stepStyle === "steps-right") {
												stepLeft
														.removeClass('holder-active');
												stepJustified
														.removeClass('holder-active');
												formWizard
														.removeClass('steps-left steps-justified');
											}
											if (stepStyle === "steps-justified") {
												stepLeft
														.removeClass('holder-active');
												stepRight
														.removeClass('holder-active');
												formWizard
														.removeClass('steps-left steps-right');
											}

											// Assign new style
											if ($(this).hasClass(
													'holder-active')) {
												formWizard
														.removeClass(stepStyle);
											} else {
												formWizard.addClass(stepStyle);
											}

											// Assign new active holder
											$(this)
													.toggleClass(
															'holder-active');

										})

						$('#datatable2')
								.dataTable(
										{
											"aoColumnDefs" : [ {
												'bSortable' : false,
												'aTargets' : [ -1 ]
											} ],
											"oLanguage" : {
												"oPaginate" : {
													"sPrevious" : "",
													"sNext" : ""
												}
											},
											"iDisplayLength" : 5,
											"aLengthMenu" : [
													[ 5, 10, 25, 50, -1 ],
													[ 5, 10, 25, 50, "All" ] ],
											"sDom" : '<"dt-panelmenu clearfix"lfr>t<"dt-panelfooter clearfix"ip>',
											"oTableTools" : {
												"sSwfPath" : "vendor/plugins/datatables/extensions/TableTools/swf/copy_csv_xls_pdf.swf"
											}
										});

						function bin(data) {
							var letter, bins = {};
							for (var i = 0, ien = data.length; i < ien; i++) {
								letter = data[i].charAt(0).toUpperCase();

								if (bins[letter]) {
									bins[letter]++;
								} else {
									bins[letter] = 1;
								}
							}
							return bins;
						}

						// ROW GROUPING

						// MISC DATATABLE HELPER FUNCTIONS

						// Add Placeholder text to datatables filter bar
						$('.dataTables_filter input').attr("placeholder",
								"Enter Terms...");
						$(".select2-single").select2();

					}

					$(".project_detail_image").click(function() {

						var imgPath = $(this).attr("src");

						$("#modal-image img").attr("src", imgPath);

						$.magnificPopup.open({
							removalDelay : 500, // delay removal by X to allow
							// out-animation,
							items : {
								src : "#modal-image"
							},
							// overflowY: 'hidden', //
							callbacks : {
								beforeOpen : function(e) {
									this.st.mainClass = "mfp-zoomIn";
								}
							},
							midClick : true
						// allow opening popup on middle mouse click. Always set
						// it to true if you don't provide alternative source.
						});
					});

				});*/